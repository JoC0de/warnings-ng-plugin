package io.jenkins.plugins.analysis.warnings;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.AbstractParser;
import edu.hm.hafner.analysis.parser.JavaDocParser;

import hudson.Extension;
import hudson.plugins.warnings.parser.Messages;

/**
 * Provides customized messages for the JavaDoc parser.
 *
 * @author Ullrich Hafner
 */
public class JavaDoc extends Java {
    @DataBoundConstructor
    public JavaDoc() {
        // empty constructor required for stapler
    }

    @Override
    protected AbstractParser createParser() {
        return new JavaDocParser();
    }

    /** Registers this tool as extension point implementation. */
    @Extension
    public static class Descriptor extends JavaDescriptor {
        public Descriptor() {
            super(new JavaDocLabelProvider());
        }
    }

    public static class JavaDocLabelProvider extends JavaLabelProvider {
        public JavaDocLabelProvider() {
            super("javadoc");
        }

        @Override
        public String getName() {
            return Messages.Warnings_JavaDoc_ParserName();
        }

        @Override
        public String getLinkName() {
            return Messages.Warnings_JavaDoc_LinkName();
        }

        @Override
        public String getTrendName() {
            return Messages.Warnings_JavaDoc_TrendName();
        }
    }
}
