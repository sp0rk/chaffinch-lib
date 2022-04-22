package io.github.sp0rk.chaffinch.lib.model

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

internal class DeckTest {
    private val bird = Bird("Black-capped chickadee", "https://example.com")
    private val deck = Deck("Garden", listOf(bird))

    @Test
    fun `GIVEN Deck with name WHEN name is requested THEN return name`() {
        // given
        val deck = deck

        // when
        val name = deck.name

        // then
        assertThat(name).isEqualTo("Garden")
    }

    @Test
    fun `GIVEN Deck with birds WHEN birds are requested THEN return birds`() {
        // given
        val deck = deck

        // when
        val bird = deck.birds.firstOrNull()

        // then
        assertThat(bird).isEqualTo(this.bird)
    }
}
