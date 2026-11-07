package com.tamedphantomsscream.mod

import com.tamedphantomsscream.mod.cry.PhantomCry
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object TamedPhantomsScream {
    const val MOD_ID = "tamedphantomsscream"

    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    fun init() {
        PhantomCry.register()
        LOGGER.info("Tamed Phantoms: Scream: крик подключён.")
    }
}
