import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ir")
@Implements("ItemLayer")
public final class ItemLayer {
	@ObfuscatedName("au")
	@Export("z")
	int z;
	@ObfuscatedName("ae")
	@Export("x")
	int x;
	@ObfuscatedName("ao")
	@Export("y")
	int y;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("first")
	Renderable first;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("second")
	Renderable second;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("third")
	Renderable third;
	@ObfuscatedName("az")
	@Export("tag")
	long tag;
	@ObfuscatedName("ap")
	@Export("height")
	int height;

	ItemLayer() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/Class;",
		garbageValue = "1457055781"
	)
	@Export("loadClassFromDescriptor")
	static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
		}
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		descriptor = "(Ldx;B)V",
		garbageValue = "-52"
	)
	static void method1152(NPC var0) {
		var0.field976 = var0.definition.size;
		var0.field1017 = var0.definition.rotation;
		var0.walkSequence = var0.definition.walkSequence;
		var0.walkBackSequence = var0.definition.walkBackSequence;
		var0.walkLeftSequence = var0.definition.walkLeftSequence;
		var0.walkRightSequence = var0.definition.walkRightSequence;
		var0.idleSequence = var0.definition.idleSequence;
		var0.turnLeftSequence = var0.definition.turnLeftSequence;
		var0.turnRightSequence = var0.definition.turnRightSequence;
		var0.runSequence = var0.definition.runSequence;
		var0.runBackSequence = var0.definition.runBackSequence;
		var0.runLeftSequence = var0.definition.runLeftSequence;
		var0.runRightSequence = var0.definition.runRightSequence;
		var0.crawlSequence = var0.definition.crawlSequence;
		var0.crawlBackSequence = var0.definition.crawlBackSequence;
		var0.crawlLeftSequence = var0.definition.crawlLeftSequence;
		var0.crawlRightSequence = var0.definition.crawlRightSequence;
	}

	@ObfuscatedName("lr")
	@ObfuscatedSignature(
		descriptor = "(Ldf;IIII)V",
		garbageValue = "-836252773"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (VarbitComposition.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				if (var0.skillLevel == 0) {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + class14.method42(var0.combatLevel, VarbitComposition.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var5;
				if (Client.isItemSelected == 1) {
					class385.insertMenuItemNoShift("Use", Client.field599 + " " + "->" + " " + MoveSpeed.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((Canvas.selectedSpellFlags & 8) == 8) {
						class385.insertMenuItemNoShift(Client.field600, Client.field601 + " " + "->" + " " + MoveSpeed.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var5 = 7; var5 >= 0; --var5) {
						if (Client.playerMenuActions[var5] != null) {
							short var6 = 0;
							if (Client.playerMenuActions[var5].equalsIgnoreCase("Attack")) {
								if (AttackOption.AttackOption_hidden == Client.playerAttackOption) {
									continue;
								}

								if (AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > VarbitComposition.localPlayer.combatLevel) {
									var6 = 2000;
								}

								if (VarbitComposition.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == VarbitComposition.localPlayer.team) {
										var6 = 2000;
									} else {
										var6 = 0;
									}
								} else if (Client.playerAttackOption == AttackOption.field1097 && var0.isClanMember()) {
									var6 = 2000;
								}
							} else if (Client.playerOptionsPriorities[var5]) {
								var6 = 2000;
							}

							boolean var7 = false;
							int var8 = Client.playerMenuOpcodes[var5] + var6;
							class385.insertMenuItemNoShift(Client.playerMenuActions[var5], MoveSpeed.colorStartTag(16777215) + var4, var8, var1, var2, var3);
						}
					}
				}

				for (var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
					if (Client.menuOpcodes[var5] == 23) {
						Client.menuTargets[var5] = MoveSpeed.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}
}