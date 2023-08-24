import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("mq")
public class class316 implements Comparator {
	@ObfuscatedName("bh")
	@Export("Widget_loadedInterfaces")
	public static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("nh")
	@Export("menuWidth")
	static int menuWidth;

	class316() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lli;Lli;I)I",
		garbageValue = "-629446065"
	)
	int method1697(class309 var1, class309 var2) {
		return var1.field2821 - var2.field2821;
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method1697((class309)var1, (class309)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		descriptor = "(IIZB)V",
		garbageValue = "-20"
	)
	static final void method1698(int var0, int var1, boolean var2) {
		if (!var2 || var0 != Tiles.timeOfPreviousKeyPress || MouseRecorder.field873 != var1) {
			Tiles.timeOfPreviousKeyPress = var0;
			MouseRecorder.field873 = var1;
			MusicSong.updateGameState(25);
			FadeInTask.drawLoadingMessage("Loading - please wait.", true);
			int var3 = UrlRequester.baseX;
			int var4 = class47.baseY;
			UrlRequester.baseX = (var0 - 6) * 8;
			class47.baseY = (var1 - 6) * 8;
			int var5 = UrlRequester.baseX - var3;
			int var6 = class47.baseY - var4;
			var3 = UrlRequester.baseX;
			var4 = class47.baseY;

			int var7;
			int var9;
			int[] var10000;
			for (var7 = 0; var7 < 65536; ++var7) {
				NPC var8 = Client.npcs[var7];
				if (var8 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var8.pathX;
						var10000[var9] -= var5;
						var10000 = var8.pathY;
						var10000[var9] -= var6;
					}

					var8.x -= var5 * 128;
					var8.y -= var6 * 128;
				}
			}

			for (var7 = 0; var7 < 2048; ++var7) {
				Player var21 = Client.players[var7];
				if (var21 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var21.pathX;
						var10000[var9] -= var5;
						var10000 = var21.pathY;
						var10000[var9] -= var6;
					}

					var21.x -= var5 * 128;
					var21.y -= var6 * 128;
				}
			}

			byte var20 = 0;
			byte var18 = 104;
			byte var22 = 1;
			if (var5 < 0) {
				var20 = 103;
				var18 = -1;
				var22 = -1;
			}

			byte var10 = 0;
			byte var11 = 104;
			byte var12 = 1;
			if (var6 < 0) {
				var10 = 103;
				var11 = -1;
				var12 = -1;
			}

			int var14;
			for (int var13 = var20; var13 != var18; var13 += var22) {
				for (var14 = var10; var14 != var11; var14 += var12) {
					int var15 = var5 + var13;
					int var16 = var6 + var14;

					for (int var17 = 0; var17 < 4; ++var17) {
						if (var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
							Client.groundItems[var17][var13][var14] = Client.groundItems[var17][var15][var16];
						} else {
							Client.groundItems[var17][var13][var14] = null;
						}
					}
				}
			}

			for (PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.last(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.previous()) {
				var19.x -= var5;
				var19.y -= var6;
				if (var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
					var19.remove();
				}
			}

			if (Client.destinationX != 0) {
				Client.destinationX -= var5;
				Client.destinationY -= var6;
			}

			Client.soundEffectCount = 0;
			Client.isCameraLocked = false;
			NPCComposition.cameraX -= var5 << 7;
			class139.cameraZ -= var6 << 7;
			FriendLoginUpdate.oculusOrbFocalPointX -= var5 << 7;
			HealthBar.oculusOrbFocalPointY -= var6 << 7;
			Client.field538 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}

	@ObfuscatedName("ma")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2123908840"
	)
	static final void method1699(int var0) {
		if (ModeWhere.loadInterface(var0)) {
			class152.drawModelComponents(PacketBufferNode.Widget_interfaceComponents[var0], -1);
		}
	}

	@ObfuscatedName("ol")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "5"
	)
	static void method1700(int var0) {
		if (var0 != Client.loginState) {
			Client.loginState = var0;
		}
	}
}