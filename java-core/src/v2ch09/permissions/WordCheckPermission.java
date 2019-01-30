package v2ch09.permissions;

import java.security.Permission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A permission that checks for bad words
 */
public class WordCheckPermission extends Permission {

    private static final String ACTION_INSERT = "insert";
    private static final String ACTION_AVOID = "avoid";

    private String action;

    /**
     * Constructs a word check permission
     *
     * @param target   a comma separated word list
     * @param anAction "insert" or "avoid"
     */
    public WordCheckPermission(String target, String anAction) {
        super(target);
        action = anAction;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (!getClass().equals(other.getClass())) return false;
        WordCheckPermission b = (WordCheckPermission) other;
        if (!Objects.equals(action, b.action)) return false;
        if (ACTION_INSERT.equals(action)) return Objects.equals(getName(), b.getName());
        else if (ACTION_AVOID.equals(action)) return badWordSet().equals(b.badWordSet());
        else
            return false;
    }

    /**
     * Gets the bad words that this permission rule describes
     * @return
     */
    public Set<String> badWordSet() {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(getName().split(",")));
        return set;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), action);
    }

    public boolean implies(Permission other) {
        if (!(other instanceof WordCheckPermission)) return false;
        WordCheckPermission b = (WordCheckPermission) other;
        if (action.equals(ACTION_INSERT)){
            return b.action.equals(ACTION_INSERT) && getName().indexOf(b.getName()) >= 0;
        }else if (action.equals(ACTION_AVOID)){
            if (b.action.equals(ACTION_AVOID)){
                return b.badWordSet().containsAll(badWordSet());
            }else if (b.action.equals(ACTION_INSERT)){
                for (String badWord : badWordSet())
                    if (b.getName().indexOf(badWord) >= 0) return false;
                return true;
            }else
                return false;
        }

        return false;
    }

    @Override
    public String getActions() {
        return action;
    }
}
