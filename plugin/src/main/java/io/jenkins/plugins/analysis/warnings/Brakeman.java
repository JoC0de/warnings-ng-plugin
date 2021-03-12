package io.jenkins.plugins.analysis.warnings;

import edu.hm.hafner.analysis.IssueParser;
import edu.hm.hafner.analysis.parser.BrakemanParser;
import edu.umd.cs.findbugs.annotations.NonNull;

import org.kohsuke.stapler.DataBoundConstructor;
import org.jenkinsci.Symbol;
import hudson.Extension;

import io.jenkins.plugins.analysis.core.model.IconLabelProvider;
import io.jenkins.plugins.analysis.core.model.ReportScanningTool;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisLabelProvider;

/**
 * Provides a parser and customized messages for Brakeman Scanner.
 */
public class Brakeman extends ReportScanningTool {
    private static final long serialVersionUID = 75319755633492904L;
    private static final String ID = "brakeman";

    /** Creates a new instance of {@link Brakeman}. */
    @DataBoundConstructor
    public Brakeman() {
        super();
        // empty constructor required for stapler
    }

    @Override
    public IssueParser createParser() {
        return new BrakemanParser();
    }

    /** Descriptor for this static analysis tool. */
    @Symbol("brakeman")
    @Extension
    public static class Descriptor extends ReportScanningToolDescriptor {
        /** Creates the descriptor instance. */
        public Descriptor() {
            super(ID);
        }

        @Override
        public boolean canScanConsoleLog() {
            return false;
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Brakeman";
        }

        @Override
        public StaticAnalysisLabelProvider getLabelProvider() {
            return new IconLabelProvider(getId(), getDisplayName(), createDescriptionProvider());
        }
    }
}
