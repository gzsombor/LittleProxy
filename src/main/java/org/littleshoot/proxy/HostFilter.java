package org.littleshoot.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a simple tool to filter out hosts, it is possible to use star character in the start or in the end. 
 * For example:
 *   new HostFilter("localhost, *.com, java.*");
 * 
 * @author Zsombor Gegesy
 */
public class HostFilter {

    interface Rule {
        boolean match(String host);
    }


    static class FixHost implements Rule {
        String host;

        public FixHost(String host) {
            super();
            this.host = host;
        }

        @Override
        public String toString() {
            return "FixHost [host=" + host + "]";
        }

        @Override
        public boolean match(String host) {
            return this.host.equals(host);
        }
    }

    static class StartsWith implements Rule {
        String prefix;

        public StartsWith(String prefix) {
            super();
            this.prefix = prefix;
        }

        @Override
        public String toString() {
            return "StartsWith [prefix=" + prefix + "]";
        }

        @Override
        public boolean match(String host) {
            return host.startsWith(prefix);
        }
    }

    static class EndWith implements Rule {
        String suffix;

        public EndWith(String suffix) {
            super();
            this.suffix = suffix;
        }

        @Override
        public String toString() {
            return "EndWith [suffix=" + suffix + "]";
        }

        @Override
        public boolean match(String host) {
            return host.endsWith(suffix);
        }
    }

    List<Rule> rules = new ArrayList<Rule>();

    public HostFilter() {
    }

    public HostFilter(String rulesString) {
        addRules(rulesString);
    }

    public synchronized void addRules(String rulesString) {
        String[] newRules = rulesString.split("[,;]");
        for (String newRule : newRules) {
            Rule rule = convert(newRule);
            if (rule != null) {
                this.rules.add(rule);
            }
        }
    }

    public synchronized void clean() {
        this.rules.clear();
    }


    Rule convert(String newRule) {
        String simplify = newRule.trim().toLowerCase();
        if (!simplify.isEmpty()) {
            if (simplify.startsWith("*")) {
                return new EndWith(simplify.substring(1));
            }
            if (simplify.endsWith("*")) {
                return new StartsWith(simplify.substring(0, simplify.length() - 1));
            }
            return new FixHost(simplify);
        }

        return null;

    }

    public synchronized boolean match(String host) {
        for (Rule r: rules) {
            if (r.match(host)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("HostFilter [rules=").append(rules).append("]");
        return builder.toString();
    }

}
