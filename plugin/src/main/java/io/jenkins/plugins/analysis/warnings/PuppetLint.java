package io.jenkins.plugins.analysis.warnings;

import edu.hm.hafner.analysis.IssueParser;
import edu.hm.hafner.analysis.parser.PuppetLintParser;
import edu.umd.cs.findbugs.annotations.NonNull;

import org.kohsuke.stapler.DataBoundConstructor;
import org.jenkinsci.Symbol;
import hudson.Extension;

import io.jenkins.plugins.analysis.core.model.ReportScanningTool;

/**
 * Provides a parser and customized messages for Puppet Lint.
 *
 * @author Ullrich Hafner
 */
public class PuppetLint extends ReportScanningTool {
    private static final long serialVersionUID = 6585663572231821338L;
    private static final String ID = "puppetlint";

    /** Creates a new instance of {@link PuppetLint}. */
    @DataBoundConstructor
    public PuppetLint() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public IssueParser createParser() {
        return new PuppetLintParser();
    }

    /** Descriptor for this static analysis tool. */
    @Symbol("puppetLint")
    @Extension
    public static class Descriptor extends ReportScanningToolDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return Messages.Warnings_Puppet_ParserName();
        }
    }
}
