import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;

@ObfuscatedName("da")
public class class85 {
	@ObfuscatedName("bk")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "0"
	)
	public static int method470(int var0, int var1, int var2) {
		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lto;B)V",
		garbageValue = "82"
	)
	static final void method471(PacketBuffer var0) {
		for (int var1 = 0; var1 < Players.Players_pendingUpdateCount; ++var1) {
			int var2 = Players.Players_pendingUpdateIndices[var1];
			Player var3 = Client.players[var2];
			int var4 = var0.readUnsignedByte();
			if ((var4 & 1) != 0) {
				var4 += var0.readUnsignedByte() << 8;
			}

			if ((var4 & 32768) != 0) {
				var4 += var0.readUnsignedByte() << 16;
			}

			class53.method294(var0, var2, var3, var4);
		}

	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-67"
	)
	@Export("doCheat")
	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			class449.clientPreferences.setRoofsHidden(!class449.clientPreferences.getRoofsHidden());
			if (class449.clientPreferences.getRoofsHidden()) {
				MouseHandler.addGameMessage(99, "", "Roofs are now all hidden");
			} else {
				MouseHandler.addGameMessage(99, "", "Roofs will only be removed selectively");
			}
		}

		if (var0.startsWith("zbuf")) {
			boolean var1 = HealthBarUpdate.method524(var0.substring(5).trim()) == 1;
			class219.client.method149(var1);
			Rasterizer3D.method1185(var1);
		}

		if (var0.equalsIgnoreCase("z")) {
			Client.renderSelf = !Client.renderSelf;
		}

		if (var0.equalsIgnoreCase("displayfps")) {
			class449.clientPreferences.method549();
		}

		if (var0.equalsIgnoreCase("renderself")) {
			Client.field386 = !Client.field386;
		}

		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.showMouseOverText = !Client.showMouseOverText;
		}

		if (Client.staffModLevel >= 2) {
			if (var0.equalsIgnoreCase("errortest")) {
				throw new RuntimeException();
			}

			if (var0.equalsIgnoreCase("showcoord")) {
				Canvas.worldMap.showCoord = !Canvas.worldMap.showCoord;
			}

			if (var0.equalsIgnoreCase("fpson")) {
				class449.clientPreferences.method548(true);
			}

			if (var0.equalsIgnoreCase("fpsoff")) {
				class449.clientPreferences.method548(false);
			}

			if (var0.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (var0.equalsIgnoreCase("clientdrop")) {
				Renderable.method1291();
			}
		}

		PacketBufferNode var2 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.CLIENT_CHEAT, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(var0.length() + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var2);
	}
}