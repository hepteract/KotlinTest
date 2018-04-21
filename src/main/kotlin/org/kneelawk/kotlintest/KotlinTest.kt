package org.kneelawk.kotlintest

import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

/**
 * Created by Kneelawk on 4/17/18.
 */
@Mod(modid = Constants.MODID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION, modLanguage = Constants.MOD_LANGUAGE, modLanguageAdapter = Constants.MOD_LANGUAGE_ADAPTER)
object KotlinTest {
    @SidedProxy(clientSide = KotlinTestProxies.client, serverSide = KotlinTestProxies.server)
    private lateinit var proxy: IKotlinTestProxy

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        proxy.preInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        KotlinTestLog.log.info("Hello from Kotlin Test!!!")
        KotlinTestLog.log.info("DIRT BLOCK >> ${Blocks.DIRT.registryName}")

        proxy.init(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }
}