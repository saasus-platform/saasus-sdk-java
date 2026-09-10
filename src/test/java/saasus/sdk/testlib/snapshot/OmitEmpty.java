package saasus.sdk.testlib.snapshot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a model field that mirrors a Go struct field tagged {@code json:",omitempty"}. Fields
 * annotated with this are omitted from serialized output when their value is "empty" in Go's
 * sense (null, empty string, empty array, or empty object), while all other {@code null} fields
 * are still emitted as {@code null} (matching Go's non-{@code omitempty} behaviour).
 *
 * @see SnapshotJson
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface OmitEmpty {
}
