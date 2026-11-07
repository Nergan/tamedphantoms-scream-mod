package com.tamedphantomsscream.mod.cry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PhantomScreamStackTest {
    @Test
    fun blindnessGrowsThenCaps() {
        assertEquals(20, PhantomScreamStack.blindnessTicks(1))
        assertEquals(40, PhantomScreamStack.blindnessTicks(2))
        assertEquals(160, PhantomScreamStack.blindnessTicks(9))
        assertEquals(160, PhantomScreamStack.blindnessTicks(12))
    }

    @Test
    fun damageStartsAtThreeAndCapsAtNine() {
        assertEquals(0.0, PhantomScreamStack.playerDamage(2, 1.0))
        assertEquals(4.0, PhantomScreamStack.playerDamage(3, 1.0), 0.001)
        assertEquals(1.0, PhantomScreamStack.playerDamage(3, 0.0), 0.001)
        assertEquals(10.0, PhantomScreamStack.playerDamage(9, 0.0), 0.001)
        assertEquals(10.0, PhantomScreamStack.playerDamage(9, 1.0), 0.001)
    }
}
