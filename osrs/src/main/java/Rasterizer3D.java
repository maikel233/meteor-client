import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("Rasterizer3D")
public class Rasterizer3D {
	@ObfuscatedName("au")
	@Export("Rasterizer3D_colorPalette")
	public static int[] Rasterizer3D_colorPalette;
	@ObfuscatedName("ae")
	static int[] field2036;
	@ObfuscatedName("ao")
	static int[] field2037;
	@ObfuscatedName("at")
	@Export("Rasterizer3D_sine")
	public static int[] Rasterizer3D_sine;
	@ObfuscatedName("ac")
	@Export("Rasterizer3D_cosine")
	public static int[] Rasterizer3D_cosine;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Ljl;"
	)
	@Export("clips")
	public static Clips clips;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lid;"
	)
	static class228 field2035;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lid;"
	)
	static final class228 field2039;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lid;"
	)
	static final class228 field2038;

	static {
		Rasterizer3D_colorPalette = new int[65536];
		field2036 = new int[512];
		field2037 = new int[2048];
		Rasterizer3D_sine = new int[2048];
		Rasterizer3D_cosine = new int[2048];

		int var0;
		for (var0 = 1; var0 < 512; ++var0) {
			field2036[var0] = 32768 / var0;
		}

		for (var0 = 1; var0 < 2048; ++var0) {
			field2037[var0] = 65536 / var0;
		}

		for (var0 = 0; var0 < 2048; ++var0) {
			Rasterizer3D_sine[var0] = (int)(65536.0D * Math.sin((double)var0 * 0.0030679615D));
			Rasterizer3D_cosine[var0] = (int)(65536.0D * Math.cos((double)var0 * 0.0030679615D));
		}

		clips = new Clips();
		field2039 = new class243(clips);
		field2038 = new class245(clips);
		field2035 = field2039;
	}

	@ObfuscatedName("au")
	public static void method1185(boolean var0) {
		if (var0 && Rasterizer2D.field4217 != null) {
			field2035 = field2038;
		} else {
			field2035 = field2039;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ljs;)V"
	)
	public static void method1186(TextureLoader var0) {
		clips.Rasterizer3D_textureLoader = var0;
	}

	@ObfuscatedName("ao")
	public static void method1187(double var0) {
		Rasterizer3D_buildPalette(var0, 0, 512);
	}

	@ObfuscatedName("at")
	@Export("Rasterizer3D_buildPalette")
	static void Rasterizer3D_buildPalette(double var0, int var2, int var3) {
		int var4 = var2 * 128;

		for (int var5 = var2; var5 < var3; ++var5) {
			double var6 = (double)(var5 >> 3) / 64.0D + 0.0078125D;
			double var8 = (double)(var5 & 7) / 8.0D + 0.0625D;

			for (int var10 = 0; var10 < 128; ++var10) {
				double var11 = (double)var10 / 128.0D;
				double var13 = var11;
				double var15 = var11;
				double var17 = var11;
				if (var8 != 0.0D) {
					double var19;
					if (var11 < 0.5D) {
						var19 = var11 * (1.0D + var8);
					} else {
						var19 = var11 + var8 - var11 * var8;
					}

					double var21 = 2.0D * var11 - var19;
					double var23 = var6 + 0.3333333333333333D;
					if (var23 > 1.0D) {
						--var23;
					}

					double var27 = var6 - 0.3333333333333333D;
					if (var27 < 0.0D) {
						++var27;
					}

					if (6.0D * var23 < 1.0D) {
						var13 = var21 + (var19 - var21) * 6.0D * var23;
					} else if (2.0D * var23 < 1.0D) {
						var13 = var19;
					} else if (3.0D * var23 < 2.0D) {
						var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
					} else {
						var13 = var21;
					}

					if (6.0D * var6 < 1.0D) {
						var15 = var21 + (var19 - var21) * 6.0D * var6;
					} else if (2.0D * var6 < 1.0D) {
						var15 = var19;
					} else if (3.0D * var6 < 2.0D) {
						var15 = var21 + (var19 - var21) * (0.6666666666666666D - var6) * 6.0D;
					} else {
						var15 = var21;
					}

					if (6.0D * var27 < 1.0D) {
						var17 = var21 + (var19 - var21) * 6.0D * var27;
					} else if (2.0D * var27 < 1.0D) {
						var17 = var19;
					} else if (3.0D * var27 < 2.0D) {
						var17 = var21 + (var19 - var21) * (0.6666666666666666D - var27) * 6.0D;
					} else {
						var17 = var21;
					}
				}

				int var29 = (int)(var13 * 256.0D);
				int var20 = (int)(var15 * 256.0D);
				int var30 = (int)(var17 * 256.0D);
				int var22 = var30 + (var20 << 8) + (var29 << 16);
				var22 = Rasterizer3D_brighten(var22, var0);
				if (var22 == 0) {
					var22 = 1;
				}

				Rasterizer3D_colorPalette[var4++] = var22;
			}
		}

	}

	@ObfuscatedName("ac")
	@Export("Rasterizer3D_brighten")
	static int Rasterizer3D_brighten(int var0, double var1) {
		double var3 = (double)(var0 >> 16) / 256.0D;
		double var5 = (double)(var0 >> 8 & 255) / 256.0D;
		double var7 = (double)(var0 & 255) / 256.0D;
		var3 = Math.pow(var3, var1);
		var5 = Math.pow(var5, var1);
		var7 = Math.pow(var7, var1);
		int var9 = (int)(var3 * 256.0D);
		int var10 = (int)(var5 * 256.0D);
		int var11 = (int)(var7 * 256.0D);
		return var11 + (var10 << 8) + (var9 << 16);
	}

	@ObfuscatedName("ai")
	@Export("getClipMidX")
	static int getClipMidX() {
		return clips.field2272;
	}

	@ObfuscatedName("az")
	@Export("getClipMidY")
	static int getClipMidY() {
		return clips.field2274;
	}

	@ObfuscatedName("ap")
	static int method1192() {
		return clips.clipNegativeMidX;
	}

	@ObfuscatedName("aa")
	@Export("getClipMidX2")
	static int getClipMidX2() {
		return clips.field2273;
	}

	@ObfuscatedName("af")
	@Export("getClipMidY2")
	static int getClipMidY2() {
		return clips.field2271;
	}

	@ObfuscatedName("ad")
	static int method1195() {
		return clips.clipNegativeMidY;
	}

	@ObfuscatedName("aq")
	@Export("get3dZoom")
	public static int get3dZoom() {
		return clips.field2280;
	}

	@ObfuscatedName("al")
	static int method1197() {
		return clips.field2276;
	}

	@ObfuscatedName("an")
	public static void method1198(int[] var0, int var1, int var2, float[] var3) {
		if (var3 == null && field2035 == field2038) {
			field2035 = field2039;
		}

		field2035.method1220(var0, var1, var2, var3);
	}

	@ObfuscatedName("ar")
	public static void method1199() {
		method1200(Rasterizer2D.Rasterizer2D_xClipStart, Rasterizer2D.Rasterizer2D_yClipStart, Rasterizer2D.Rasterizer2D_xClipEnd, Rasterizer2D.Rasterizer2D_yClipEnd);
	}

	@ObfuscatedName("ab")
	static void method1200(int var0, int var1, int var2, int var3) {
		clips.field2276 = var2 - var0;
		clips.field2269 = var3 - var1;
		method1201();
		if (clips.Rasterizer3D_rowOffsets.length < clips.field2269) {
			clips.Rasterizer3D_rowOffsets = new int[WorldMapIcon_1.method1401(clips.field2269)];
		}

		int var4 = var0 + Rasterizer2D.Rasterizer2D_width * var1;

		for (int var5 = 0; var5 < clips.field2269; ++var5) {
			clips.Rasterizer3D_rowOffsets[var5] = var4;
			var4 += Rasterizer2D.Rasterizer2D_width;
		}

	}

	@ObfuscatedName("ag")
	public static void method1201() {
		clips.method1361();
	}

	@ObfuscatedName("am")
	public static void method1202(int var0, int var1) {
		int var2 = clips.Rasterizer3D_rowOffsets[0];
		int var3 = var2 / Rasterizer2D.Rasterizer2D_width;
		int var4 = var2 - var3 * Rasterizer2D.Rasterizer2D_width;
		clips.method1362(var0, var4, var1, var3);
	}

	@ObfuscatedName("ax")
	public static void method1203(int var0, int var1, int var2) {
		clips.method1363(var0, var1, var2);
	}

	@ObfuscatedName("ah")
	static void method1204(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9, int var10, int var11) {
		field2035.vmethod1374(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
	}

	@ObfuscatedName("as")
	public static void method1205(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9) {
		field2035.vmethod1366(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
	}

	@ObfuscatedName("ay")
	static void method1206(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21) {
		field2035.vmethod1378(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21);
	}

	@ObfuscatedName("aj")
	static void method1207(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21) {
		field2035.vmethod1362(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21);
	}

	@ObfuscatedName("av")
	static void method1208(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9, int var10, int var11, byte var12, byte var13, byte var14, byte var15) {
		field2035.method1223(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
	}

	@ObfuscatedName("aw")
	static void method1209(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9, byte var10, byte var11, byte var12, byte var13) {
		field2035.method1224(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
	}
}