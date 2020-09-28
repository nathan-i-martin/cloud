//
// MIT License
//
// Copyright (c) 2020 Alexander Söderberg & Contributors
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
package cloud.commandframework.types.tuples;

import com.google.common.base.Objects;

import javax.annotation.Nonnull;

/**
 * Immutable generic 5-tuple
 *
 * @param <U> First type
 * @param <V> Second type
 * @param <W> Third type
 * @param <X> Fourth type
 */
public class Quartet<U, V, W, X> implements Tuple {

    @Nonnull
    private final U first;
    @Nonnull
    private final V second;
    @Nonnull
    private final W third;
    @Nonnull
    private final X fourth;

    protected Quartet(@Nonnull final U first,
                      @Nonnull final V second,
                      @Nonnull final W third,
                      @Nonnull final X fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    /**
     * Create a new 4-tuple
     *
     * @param first  First value
     * @param second Second value
     * @param third  Third value
     * @param fourth Fourth value
     * @param <U>    First type
     * @param <V>    Second type
     * @param <W>    Third type
     * @param <X>    Fourth type
     * @return Created quartet
     */
    @Nonnull
    public static <U, V, W, X> Quartet<U, V, W, X> of(@Nonnull final U first,
                                                      @Nonnull final V second,
                                                      @Nonnull final W third,
                                                      @Nonnull final X fourth) {
        return new Quartet<>(first, second, third, fourth);
    }

    /**
     * Get the first value
     *
     * @return First value
     */
    @Nonnull
    public final U getFirst() {
        return this.first;
    }

    /**
     * Get the second value
     *
     * @return Second value
     */
    @Nonnull
    public final V getSecond() {
        return this.second;
    }

    /**
     * Get the third value
     *
     * @return Third value
     */
    @Nonnull
    public final W getThird() {
        return this.third;
    }

    /**
     * Get the fourth value
     *
     * @return Fourth value
     */
    @Nonnull
    public final X getFourth() {
        return this.fourth;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Quartet<?, ?, ?, ?> quartet = (Quartet<?, ?, ?, ?>) o;
        return Objects.equal(getFirst(), quartet.getFirst())
                && Objects.equal(getSecond(), quartet.getSecond())
                && Objects.equal(getThird(), quartet.getThird())
                && Objects.equal(getFourth(), quartet.getFourth());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getFirst(), getSecond(), getThird(), getFourth());
    }

    @Override
    public final String toString() {
        return String.format("(%s, %s, %s, %s)", this.first, this.second, this.third, this.fourth);
    }

    @Override
    public final int getSize() {
        return Tuples.SIZE_QUARTET;
    }

    @Nonnull
    @Override
    public final Object[] toArray() {
        final Object[] array = new Object[4];
        array[0] = this.first;
        array[1] = this.second;
        array[3] = this.third;
        array[4] = this.fourth;
        return array;
    }

}