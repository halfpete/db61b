// This is a SUGGESTED skeleton for a class that describes a single
// Condition (such as CCN = '99776').  You can throw this away if you
// want,  but it is a good idea to try to understand it first.
// Our solution changes or adds about 30 lines in this skeleton.

// Comments that start with "//" are intended to be removed from your
// solutions.
package db61b;

import java.util.List;

/** Represents a single 'where' condition in a 'select' command.
 *  @author Yusuke Maruo*/
class Condition {

    /** A Condition representing COL1 RELATION COL2, where COL1 and COL2
     *  are column designators. and RELATION is one of the
     *  strings "<", ">", "<=", ">=", "=", or "!=". */
    Condition(Column col1, String relation, Column col2) {
        _col1 = col1;
        _col2 = col2;
        _relation = relation;
    }

    /** A Condition representing COL1 RELATION 'VAL2', where COL1 is
     *  a column designator, VAL2 is a literal value (without the
     *  quotes), and RELATION is one of the strings "<", ">", "<=",
     *  ">=", "=", or "!=".
     */
    Condition(Column col1, String relation, String val2) {
        this(col1, relation, (Column) null);
        _val2 = val2;
    }

    /** Assuming that ROWS are rows from the respective tables from which
     *  my columns are selected, returns the result of performing the test I
     *  denote. */
    boolean test(Row... rows) {
    	int val;
    	if (_col2 == null) {
    		val = _col1.getFrom(rows).compareTo(_val2);
    	} else {
    		val = _col1.getFrom(rows).compareTo(_col2.getFrom(rows));
    	}
        switch (_relation) {
        case "<":
        	return val < 0;
        case ">":
        	return val > 0;
        case "<=":
        	return val <= 0;
        case ">=":
        	return val >= 0;
        case "=":
        	return val == 0;
        case "!=":
        	return val != 0;
        }
        return false;
    }

    /** Return true iff ROWS satisfies all CONDITIONS. */
    static boolean test(List<Condition> conditions, Row... rows) {
        for (Condition cond : conditions) {
            if (!cond.test(rows)) {
                return false;
            }
        }
        return true;
    }

    /** The operands of this condition.  _col2 is null if the second operand
     *  is a literal. */
    private Column _col1, _col2;
    /** Second operand, if literal (otherwise null). */
    private String _val2;
    private String _relation;
}