import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ObfuscatedName("ed")
@Implements("TileItem")
public final class TileItem extends Renderable {
	@ObfuscatedName("au")
	@Export("id")
	int id;
	@ObfuscatedName("ae")
	@Export("quantity")
	int quantity;
	@ObfuscatedName("at")
	int field1104;

	TileItem() {
		this.field1104 = 31;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "11584"
	)
	void method609(int var1) {
		this.field1104 = var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Ljr;",
		garbageValue = "798227647"
	)
	@Export("getModel")
	protected final Model getModel() {
		return InvDefinition.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1782436453"
	)
	boolean method610(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1104 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lgh;III)Lbb;",
		garbageValue = "881365546"
	)
	public static final PcmPlayer method612(TaskHandler var0, int var1, int var2) {
		if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = FloorDecoration.pcmPlayerProvider.player();
				var3.samples = new int[256 * (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
				var3.field194 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (PcmPlayer.field182 > 0 && Canvas.soundSystem == null) {
					Canvas.soundSystem = new SoundSystem();
					PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(Canvas.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (Canvas.soundSystem != null) {
					if (Canvas.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					Canvas.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}