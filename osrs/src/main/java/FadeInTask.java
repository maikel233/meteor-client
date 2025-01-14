import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pt")
@Implements("FadeInTask")
public class FadeInTask extends SongTask {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lmu;"
	)
	MusicSong field3719;
	@ObfuscatedName("ae")
	int field3718;

	@ObfuscatedSignature(
		descriptor = "(Lpm;IZI)V"
	)
	public FadeInTask(SongTask var1, int var2, boolean var3, int var4) {
		super(var1);
		this.field3719 = null;
		this.field3718 = 0;
		super.field3722 = "FadeInTask";
		if (var2 >= 0) {
			if (var3 && var2 < class305.field2774.size()) {
				this.field3719 = (MusicSong)class305.field2774.get(var2);
			} else if (!var3 && var2 < class305.musicSongs.size()) {
				this.field3719 = (MusicSong)class305.musicSongs.get(var2);
			}

			this.field3718 = var4;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1604030758"
	)
	public boolean vmethod2142() {
		if (this.field3719 != null && this.field3719.midiPcmStream != null) {
			this.field3719.field2862 = true;

			try {
				if (this.field3719.field2867 < (float)this.field3719.musicTrackVolume && this.field3719.midiPcmStream.isReady()) {
					float var1 = this.field3718 == 0 ? (float)this.field3718 : (float)this.field3719.musicTrackVolume / (float)this.field3718;
					MusicSong var10000 = this.field3719;
					var10000.field2867 += 0.0F == var1 ? (float)this.field3719.musicTrackVolume : var1;
					if (this.field3719.field2867 > (float)this.field3719.musicTrackVolume) {
						this.field3719.field2867 = (float)this.field3719.musicTrackVolume;
					}

					this.field3719.midiPcmStream.setPcmStreamVolume((int)this.field3719.field2867);
					return false;
				}
			} catch (Exception var3) {
				this.method2138(var3.getMessage());
				return true;
			}

			this.field3719.field2862 = false;
			return true;
		} else {
			return true;
		}
	}

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZB)V",
		garbageValue = "0"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = SecureRandomCallable.fontPlain12.lineWidth(var0, 250);
			int var6 = SecureRandomCallable.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
			SecureRandomCallable.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			int var7 = var3 - var2;
			int var8 = var4 - var2;
			int var9 = var2 + var5 + var2;
			int var10 = var2 + var6 + var2;

			for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
				if (Client.rootWidgetXs[var11] + Client.rootWidgetWidths[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetYs[var11] + Client.rootWidgetHeights[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
					Client.field407[var11] = true;
				}
			}

			if (var1) {
				AttackOption.rasterProvider.drawFull(0, 0);
			} else {
				DevicePcmPlayerProvider.method76(var3, var4, var5, var6);
			}

		}
	}
}