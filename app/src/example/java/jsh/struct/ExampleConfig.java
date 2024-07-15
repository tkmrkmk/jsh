package jsh.struct;

import java.util.Objects;

/**
 * Example DB connection config class
 */
public class ExampleConfig {
    public final String url;
    public final String user;
    public final String password;

    ExampleConfig(final String url, final String user, final String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public interface Builder {
        Builder url(String url);

        Builder password(String password);

        Builder user(String user);

        ExampleConfig build();
    }

    private static class BuilderImpl implements Builder {
        String url;
        String password;
        String user;

        @Override
        public Builder url(final String url) {
            this.url = url;
            return this;
        }

        @Override
        public Builder password(final String password) {
            this.password = password;
            return this;
        }

        @Override
        public Builder user(final String user) {
            this.user = user;
            return this;
        }

        @Override
        public ExampleConfig build() {
            Objects.requireNonNull(this.url, "url missing");
            Objects.requireNonNull(this.user, "user missing");
            Objects.requireNonNull(this.password, "password missing");
            return new ExampleConfig(url, user, password);
        }
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    @Override
    public String toString() {
        return String.format("ExampleConfig {url: %s, user: %s, password: %s}",
                url, user, password);
    }
}
