import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.IOException;

@ObfuscatedName("gb")
public class class165 extends class143 {
	@ObfuscatedName("au")
	long field1431;
	@ObfuscatedName("ae")
	String field1430;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfn;"
	)
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfn;)V"
	)
	class165(class146 var1) {
		this.this$0 = var1;
		this.field1431 = -1L;
		this.field1430 = null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "209179459"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1431 = var1.readLong();
		}

		this.field1430 = var1.readStringCp1252NullTerminatedOrNull();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfi;B)V",
		garbageValue = "73"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method815(this.field1431, this.field1430);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ljava/io/File;Ljava/io/File;I)V",
		garbageValue = "1715361402"
	)
	static void method868(File var0, File var1) {
		try {
			AccessFile var2 = new AccessFile(JagexCache.field1463, "rw", 10000L);
			Buffer var3 = new Buffer(500);
			var3.writeByte(3);
			var3.writeByte(var1 != null ? 1 : 0);
			var3.writeCESU8(var0.getPath());
			if (var1 != null) {
				var3.writeCESU8("");
			}

			var2.write(var3.array, 0, var3.offset);
			var2.close();
		} catch (IOException var4) {
			var4.printStackTrace();
		}

	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "97"
	)
	static final void method869() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.endCycle == -1) {
				var0.startCycle = 0;
				PacketWriter.method646(var0);
			} else {
				var0.remove();
			}
		}

	}
}