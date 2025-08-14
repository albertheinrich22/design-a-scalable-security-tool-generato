// Neow Design a Scalable Security Tool Generator

package com.neow.security.tool.generator

import java.util.*

enum class SecurityToolType {
    FIREWALL,
    INTRUSION_DETECTION,
    ENCRYPTION,
    ACCESS_CONTROL
}

data class SecurityToolConfig(
    val toolType: SecurityToolType,
    val toolName: String,
    val params: Map<String, String>
)

interface SecurityToolGenerator {
    fun generateSecurityTool(config: SecurityToolConfig): SecurityTool
}

abstract class SecurityTool {
    abstract fun init()
    abstract fun start()
    abstract fun stop()
}

class SecurityToolGeneratorImpl : SecurityToolGenerator {
    override fun generateSecurityTool(config: SecurityToolConfig): SecurityTool {
        return when (config.toolType) {
            SecurityToolType.FIREWALL -> FirewallTool(config)
            SecurityToolType.INTRUSION_DETECTION -> IntrusionDetectionTool(config)
            SecurityToolType.ENCRYPTION -> EncryptionTool(config)
            SecurityToolType.ACCESS_CONTROL -> AccessControlTool(config)
        }
    }
}

class FirewallTool(config: SecurityToolConfig) : SecurityTool() {
    override fun init() {
        println("Initializing firewall tool ${config.toolName}")
    }

    override fun start() {
        println("Starting firewall tool ${config.toolName}")
    }

    override fun stop() {
        println("Stopping firewall tool ${config.toolName}")
    }
}

class IntrusionDetectionTool(config: SecurityToolConfig) : SecurityTool() {
    override fun init() {
        println("Initializing intrusion detection tool ${config.toolName}")
    }

    override fun start() {
        println("Starting intrusion detection tool ${config.toolName}")
    }

    override fun stop() {
        println("Stopping intrusion detection tool ${config.toolName}")
    }
}

class EncryptionTool(config: SecurityToolConfig) : SecurityTool() {
    override fun init() {
        println("Initializing encryption tool ${config.toolName}")
    }

    override fun start() {
        println("Starting encryption tool ${config.toolName}")
    }

    override fun stop() {
        println("Stopping encryption tool ${config.toolName}")
    }
}

class AccessControlTool(config: SecurityToolConfig) : SecurityTool() {
    override fun init() {
        println("Initializing access control tool ${config.toolName}")
    }

    override fun start() {
        println("Starting access control tool ${config.toolName}")
    }

    override fun stop() {
        println("Stopping access control tool ${config.toolName}")
    }
}

fun main() {
    val config = SecurityToolConfig(
        toolType = SecurityToolType.FIREWALL,
        toolName = "Firewall Tool",
        params = mapOf("port" to "8080", "protocol" to "TCP")
    )

    val generator = SecurityToolGeneratorImpl()
    val tool = generator.generateSecurityTool(config)
    tool.init()
    tool.start()
    tool.stop()
}