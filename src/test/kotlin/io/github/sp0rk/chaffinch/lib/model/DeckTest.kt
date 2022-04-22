package io.github.sp0rk.chaffinch.lib.model

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

internal class DeckTest {
    @Test
    fun `GIVEN Deck with name WHEN name is requested THEN return name`() {
        // given
        val deck = Deck("test")

        // when
        val name = deck.name

        // then
        assertThat(name).isEqualTo("test")
    }
}