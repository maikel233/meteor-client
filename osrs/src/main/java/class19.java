import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.concurrent.Callable;

@ObfuscatedName("ah")
public class class19 implements Callable {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lad;"
	)
	final class10 field54;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lar;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class14 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lar;Lad;)V"
	)
	class19(class14 var1, class10 var2) {
		this.this$0 = var1;
		this.field54 = var2;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() throws Exception {
		try {
			while (this.field54.method30()) {
				PendingSpawn.method505(10L);
			}
		} catch (IOException var2) {
			return new class20("Error servicing REST query: " + var2.getMessage());
		}

		return this.field54.method31();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1773391988"
	)
	public static void method60() {
		DbRowType.DBRowType_cache.clear();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIIII)I",
		garbageValue = "1020330780"
	)
	static final int method61(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}

	@ObfuscatedName("my")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-274496968"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (ModeWhere.loadInterface(var0)) {
			Widget[] var1 = PacketBufferNode.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}
}