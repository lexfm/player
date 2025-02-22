package com.intuit.player.jvm.core.asset

import com.intuit.player.jvm.core.bridge.Node
import com.intuit.player.jvm.core.bridge.NodeWrapper
import com.intuit.player.jvm.core.bridge.serialization.serializers.NodeSerializableField
import com.intuit.player.jvm.core.bridge.serialization.serializers.NodeWrapperSerializer
import com.intuit.player.jvm.core.player.PlayerException
import kotlinx.serialization.Serializable

/**
 * Container for an [Asset] definition. [node] is exposed because there might be metaData at the wrapper level.
 */
@Serializable(with = AssetWrapper.Serializer::class)
public class AssetWrapper(override val node: Node) : NodeWrapper {
    public val asset: Asset by NodeSerializableField(Asset.serializer()) {
        throw PlayerException("AssetWrapper is not wrapping a valid asset")
    }

    internal object Serializer : NodeWrapperSerializer<AssetWrapper>(::AssetWrapper)
}
