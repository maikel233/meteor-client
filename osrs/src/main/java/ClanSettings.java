import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("ClanSettings")
public class ClanSettings {
	@ObfuscatedName("ae")
	@Export("useHashes")
	boolean useHashes;
	@ObfuscatedName("ao")
	@Export("useNames")
	boolean useNames;
	@ObfuscatedName("at")
	long field1377;
	@ObfuscatedName("ac")
	public int field1388;
	@ObfuscatedName("ai")
	@Export("name")
	public String name;
	@ObfuscatedName("az")
	int field1374;
	@ObfuscatedName("ap")
	@Export("allowGuests")
	public boolean allowGuests;
	@ObfuscatedName("aa")
	public byte field1383;
	@ObfuscatedName("af")
	public byte field1385;
	@ObfuscatedName("ad")
	public byte field1384;
	@ObfuscatedName("aq")
	public byte field1386;
	@ObfuscatedName("al")
	@Export("memberCount")
	public int memberCount;
	@ObfuscatedName("an")
	@Export("memberHashes")
	long[] memberHashes;
	@ObfuscatedName("ar")
	@Export("memberRanks")
	public byte[] memberRanks;
	@ObfuscatedName("ab")
	@Export("sortedMembers")
	int[] sortedMembers;
	@ObfuscatedName("ag")
	int[] field1376;
	@ObfuscatedName("am")
	public int[] field1393;
	@ObfuscatedName("ax")
	public boolean[] field1382;
	@ObfuscatedName("ah")
	@Export("currentOwner")
	public int currentOwner;
	@ObfuscatedName("as")
	public int field1391;
	@ObfuscatedName("ay")
	@Export("bannedMemberCount")
	public int bannedMemberCount;
	@ObfuscatedName("aj")
	@Export("bannedMemberHashes")
	long[] bannedMemberHashes;
	@ObfuscatedName("av")
	@Export("memberNames")
	public String[] memberNames;
	@ObfuscatedName("aw")
	@Export("bannedMemberNames")
	public String[] bannedMemberNames;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lsf;"
	)
	@Export("parameters")
	IterableNodeHashTable parameters;

	@ObfuscatedSignature(
		descriptor = "(Ltm;)V"
	)
	public ClanSettings(Buffer var1) {
		this.field1388 = 0;
		this.name = null;
		this.field1374 = 0;
		this.currentOwner = -1;
		this.field1391 = -1;
		this.method825(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1511272498"
	)
	void method806(int var1) {
		if (this.useHashes) {
			if (this.memberHashes != null) {
				System.arraycopy(this.memberHashes, 0, this.memberHashes = new long[var1], 0, this.memberCount);
			} else {
				this.memberHashes = new long[var1];
			}
		}

		if (this.useNames) {
			if (this.memberNames != null) {
				System.arraycopy(this.memberNames, 0, this.memberNames = new String[var1], 0, this.memberCount);
			} else {
				this.memberNames = new String[var1];
			}
		}

		if (this.memberRanks != null) {
			System.arraycopy(this.memberRanks, 0, this.memberRanks = new byte[var1], 0, this.memberCount);
		} else {
			this.memberRanks = new byte[var1];
		}

		if (this.field1376 != null) {
			System.arraycopy(this.field1376, 0, this.field1376 = new int[var1], 0, this.memberCount);
		} else {
			this.field1376 = new int[var1];
		}

		if (this.field1393 != null) {
			System.arraycopy(this.field1393, 0, this.field1393 = new int[var1], 0, this.memberCount);
		} else {
			this.field1393 = new int[var1];
		}

		if (this.field1382 != null) {
			System.arraycopy(this.field1382, 0, this.field1382 = new boolean[var1], 0, this.memberCount);
		} else {
			this.field1382 = new boolean[var1];
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "7"
	)
	void method807(int var1) {
		if (this.useHashes) {
			if (this.bannedMemberHashes != null) {
				System.arraycopy(this.bannedMemberHashes, 0, this.bannedMemberHashes = new long[var1], 0, this.bannedMemberCount);
			} else {
				this.bannedMemberHashes = new long[var1];
			}
		}

		if (this.useNames) {
			if (this.bannedMemberNames != null) {
				System.arraycopy(this.bannedMemberNames, 0, this.bannedMemberNames = new String[var1], 0, this.bannedMemberCount);
			} else {
				this.bannedMemberNames = new String[var1];
			}
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "-849658856"
	)
	public int method808(String var1) {
		if (var1 != null && var1.length() != 0) {
			for (int var2 = 0; var2 < this.memberCount; ++var2) {
				if (this.memberNames[var2].equals(var1)) {
					return var2;
				}
			}

			return -1;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "1158045265"
	)
	public int method809(int var1, int var2, int var3) {
		int var4 = var3 == 31 ? -1 : (1 << var3 + 1) - 1;
		return (this.field1376[var1] & var4) >>> var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/Integer;",
		garbageValue = "1038796157"
	)
	@Export("getTitleGroupValue")
	public Integer getTitleGroupValue(int var1) {
		if (this.parameters == null) {
			return null;
		} else {
			Node var2 = this.parameters.get((long)var1);
			return var2 != null && var2 instanceof IntegerNode ? new Integer(((IntegerNode)var2).integer) : null;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-521962752"
	)
	@Export("getSortedMembers")
	public int[] getSortedMembers() {
		if (this.sortedMembers == null) {
			String[] var1 = new String[this.memberCount];
			this.sortedMembers = new int[this.memberCount];

			for (int var2 = 0; var2 < this.memberCount; this.sortedMembers[var2] = var2++) {
				var1[var2] = this.memberNames[var2];
				if (var1[var2] != null) {
					var1[var2] = var1[var2].toLowerCase();
				}
			}

			int[] var3 = this.sortedMembers;
			VerticalAlignment.method998(var1, var3, 0, var1.length - 1);
		}

		return this.sortedMembers;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(JLjava/lang/String;IB)V",
		garbageValue = "-21"
	)
	void method812(long var1, String var3, int var4) {
		if (var3 != null && var3.length() == 0) {
			var3 = null;
		}

		if (this.useHashes != var1 > 0L) {
			throw new RuntimeException("");
		} else if (this.useNames != (var3 != null)) {
			throw new RuntimeException("");
		} else {
			if (var1 > 0L && (this.memberHashes == null || this.memberCount >= this.memberHashes.length) || var3 != null && (this.memberNames == null || this.memberCount >= this.memberNames.length)) {
				this.method806(this.memberCount + 5);
			}

			if (this.memberHashes != null) {
				this.memberHashes[this.memberCount] = var1;
			}

			if (this.memberNames != null) {
				this.memberNames[this.memberCount] = var3;
			}

			if (this.currentOwner == -1) {
				this.currentOwner = this.memberCount;
				this.memberRanks[this.memberCount] = 126;
			} else {
				this.memberRanks[this.memberCount] = 0;
			}

			this.field1376[this.memberCount] = 0;
			this.field1393[this.memberCount] = var4;
			this.field1382[this.memberCount] = false;
			++this.memberCount;
			this.sortedMembers = null;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-22"
	)
	void method813(int var1) {
		if (var1 >= 0 && var1 < this.memberCount) {
			--this.memberCount;
			this.sortedMembers = null;
			if (this.memberCount == 0) {
				this.memberHashes = null;
				this.memberNames = null;
				this.memberRanks = null;
				this.field1376 = null;
				this.field1393 = null;
				this.field1382 = null;
				this.currentOwner = -1;
				this.field1391 = -1;
			} else {
				System.arraycopy(this.memberRanks, var1 + 1, this.memberRanks, var1, this.memberCount - var1);
				System.arraycopy(this.field1376, var1 + 1, this.field1376, var1, this.memberCount - var1);
				System.arraycopy(this.field1393, var1 + 1, this.field1393, var1, this.memberCount - var1);
				System.arraycopy(this.field1382, var1 + 1, this.field1382, var1, this.memberCount - var1);
				if (this.memberHashes != null) {
					System.arraycopy(this.memberHashes, var1 + 1, this.memberHashes, var1, this.memberCount - var1);
				}

				if (this.memberNames != null) {
					System.arraycopy(this.memberNames, var1 + 1, this.memberNames, var1, this.memberCount - var1);
				}

				this.updateOwner();
			}

		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1152334560"
	)
	@Export("updateOwner")
	void updateOwner() {
		if (this.memberCount == 0) {
			this.currentOwner = -1;
			this.field1391 = -1;
		} else {
			this.currentOwner = -1;
			this.field1391 = -1;
			int var1 = 0;
			byte var2 = this.memberRanks[0];

			for (int var3 = 1; var3 < this.memberCount; ++var3) {
				if (this.memberRanks[var3] > var2) {
					if (var2 == 125) {
						this.field1391 = var1;
					}

					var1 = var3;
					var2 = this.memberRanks[var3];
				} else if (this.field1391 == -1 && this.memberRanks[var3] == 125) {
					this.field1391 = var3;
				}
			}

			this.currentOwner = var1;
			if (this.currentOwner != -1) {
				this.memberRanks[this.currentOwner] = 126;
			}

		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(JLjava/lang/String;I)V",
		garbageValue = "-1457470912"
	)
	void method815(long var1, String var3) {
		if (var3 != null && var3.length() == 0) {
			var3 = null;
		}

		if (this.useHashes != var1 > 0L) {
			throw new RuntimeException("");
		} else if (var3 != null != this.useNames) {
			throw new RuntimeException("");
		} else {
			if (var1 > 0L && (this.bannedMemberHashes == null || this.bannedMemberCount >= this.bannedMemberHashes.length) || var3 != null && (this.bannedMemberNames == null || this.bannedMemberCount >= this.bannedMemberNames.length)) {
				this.method807(this.bannedMemberCount + 5);
			}

			if (this.bannedMemberHashes != null) {
				this.bannedMemberHashes[this.bannedMemberCount] = var1;
			}

			if (this.bannedMemberNames != null) {
				this.bannedMemberNames[this.bannedMemberCount] = var3;
			}

			++this.bannedMemberCount;
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "509826850"
	)
	void method816(int var1) {
		--this.bannedMemberCount;
		if (this.bannedMemberCount == 0) {
			this.bannedMemberHashes = null;
			this.bannedMemberNames = null;
		} else {
			if (this.bannedMemberHashes != null) {
				System.arraycopy(this.bannedMemberHashes, var1 + 1, this.bannedMemberHashes, var1, this.bannedMemberCount - var1);
			}

			if (this.bannedMemberNames != null) {
				System.arraycopy(this.bannedMemberNames, var1 + 1, this.bannedMemberNames, var1, this.bannedMemberCount - var1);
			}
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IBB)I",
		garbageValue = "91"
	)
	int method817(int var1, byte var2) {
		if (var2 != 126 && var2 != 127) {
			if (this.currentOwner == var1 && (this.field1391 == -1 || this.memberRanks[this.field1391] < 125)) {
				return -1;
			} else if (this.memberRanks[var1] == var2) {
				return -1;
			} else {
				this.memberRanks[var1] = var2;
				this.updateOwner();
				return var1;
			}
		} else {
			return -1;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1652565060"
	)
	boolean method818(int var1) {
		if (this.currentOwner != var1 && this.memberRanks[var1] != 126) {
			this.memberRanks[this.currentOwner] = 125;
			this.field1391 = this.currentOwner;
			this.memberRanks[var1] = 126;
			this.currentOwner = var1;
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "-1953931812"
	)
	int method819(int var1, boolean var2) {
		if (this.field1382[var1] == var2) {
			return -1;
		} else {
			this.field1382[var1] = var2;
			return var1;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIIII)I",
		garbageValue = "-637099928"
	)
	int method820(int var1, int var2, int var3, int var4) {
		int var5 = (1 << var3) - 1;
		int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
		int var7 = var6 ^ var5;
		var2 <<= var3;
		var2 &= var7;
		int var8 = this.field1376[var1];
		if ((var8 & var7) == var2) {
			return -1;
		} else {
			var8 &= ~var7;
			this.field1376[var1] = var8 | var2;
			return var1;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-2075021651"
	)
	boolean method821(int var1, int var2) {
		if (this.parameters != null) {
			Node var3 = this.parameters.get((long)var1);
			if (var3 != null) {
				if (var3 instanceof IntegerNode) {
					IntegerNode var4 = (IntegerNode)var3;
					if (var2 == var4.integer) {
						return false;
					}

					var4.integer = var2;
					return true;
				}

				var3.remove();
			}
		} else {
			this.parameters = new IterableNodeHashTable(4);
		}

		this.parameters.put(new IntegerNode(var2), (long)var1);
		return true;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)Z",
		garbageValue = "0"
	)
	boolean method822(int var1, int var2, int var3, int var4) {
		int var5 = (1 << var3) - 1;
		int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
		int var7 = var6 ^ var5;
		var2 <<= var3;
		var2 &= var7;
		if (this.parameters != null) {
			Node var8 = this.parameters.get((long)var1);
			if (var8 != null) {
				if (var8 instanceof IntegerNode) {
					IntegerNode var9 = (IntegerNode)var8;
					if ((var9.integer & var7) == var2) {
						return false;
					}

					var9.integer &= ~var7;
					var9.integer |= var2;
					return true;
				}

				var8.remove();
			}
		} else {
			this.parameters = new IterableNodeHashTable(4);
		}

		this.parameters.put(new IntegerNode(var2), (long)var1);
		return true;
	}

	@ObfuscatedName("am")
	boolean method823(int var1, long var2) {
		if (this.parameters != null) {
			Node var4 = this.parameters.get((long)var1);
			if (var4 != null) {
				if (var4 instanceof LongNode) {
					LongNode var5 = (LongNode)var4;
					if (var5.longValue == var2) {
						return false;
					}

					var5.longValue = var2;
					return true;
				}

				var4.remove();
			}
		} else {
			this.parameters = new IterableNodeHashTable(4);
		}

		this.parameters.put(new LongNode(var2), (long)var1);
		return true;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)Z",
		garbageValue = "-713995944"
	)
	boolean method824(int var1, String var2) {
		if (var2 == null) {
			var2 = "";
		} else if (var2.length() > 80) {
			var2 = var2.substring(0, 80);
		}

		if (this.parameters != null) {
			Node var3 = this.parameters.get((long)var1);
			if (var3 != null) {
				if (var3 instanceof ObjectNode) {
					ObjectNode var4 = (ObjectNode)var3;
					if (var4.obj instanceof String) {
						if (var2.equals(var4.obj)) {
							return false;
						}

						var4.remove();
						this.parameters.put(new ObjectNode(var2), var4.key);
						return true;
					}
				}

				var3.remove();
			}
		} else {
			this.parameters = new IterableNodeHashTable(4);
		}

		this.parameters.put(new ObjectNode(var2), (long)var1);
		return true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "633008304"
	)
	void method825(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 >= 1 && var2 <= 6) {
			int var3 = var1.readUnsignedByte();
			if ((var3 & 1) != 0) {
				this.useHashes = true;
			}

			if ((var3 & 2) != 0) {
				this.useNames = true;
			}

			if (!this.useHashes) {
				this.memberHashes = null;
				this.bannedMemberHashes = null;
			}

			if (!this.useNames) {
				this.memberNames = null;
				this.bannedMemberNames = null;
			}

			this.field1388 = var1.readInt();
			this.field1374 = var1.readInt();
			if (var2 <= 3 && this.field1374 != 0) {
				this.field1374 += 16912800;
			}

			this.memberCount = var1.readUnsignedShort();
			this.bannedMemberCount = var1.readUnsignedByte();
			this.name = var1.readStringCp1252NullTerminated();
			if (var2 >= 4) {
				var1.readInt();
			}

			this.allowGuests = var1.readUnsignedByte() == 1;
			this.field1383 = var1.readByte();
			this.field1385 = var1.readByte();
			this.field1384 = var1.readByte();
			this.field1386 = var1.readByte();
			int var4;
			if (this.memberCount > 0) {
				if (this.useHashes && (this.memberHashes == null || this.memberHashes.length < this.memberCount)) {
					this.memberHashes = new long[this.memberCount];
				}

				if (this.useNames && (this.memberNames == null || this.memberNames.length < this.memberCount)) {
					this.memberNames = new String[this.memberCount];
				}

				if (this.memberRanks == null || this.memberRanks.length < this.memberCount) {
					this.memberRanks = new byte[this.memberCount];
				}

				if (this.field1376 == null || this.field1376.length < this.memberCount) {
					this.field1376 = new int[this.memberCount];
				}

				if (this.field1393 == null || this.field1393.length < this.memberCount) {
					this.field1393 = new int[this.memberCount];
				}

				if (this.field1382 == null || this.field1382.length < this.memberCount) {
					this.field1382 = new boolean[this.memberCount];
				}

				for (var4 = 0; var4 < this.memberCount; ++var4) {
					if (this.useHashes) {
						this.memberHashes[var4] = var1.readLong();
					}

					if (this.useNames) {
						this.memberNames[var4] = var1.readStringCp1252NullTerminatedOrNull();
					}

					this.memberRanks[var4] = var1.readByte();
					if (var2 >= 2) {
						this.field1376[var4] = var1.readInt();
					}

					if (var2 >= 5) {
						this.field1393[var4] = var1.readUnsignedShort();
					} else {
						this.field1393[var4] = 0;
					}

					if (var2 >= 6) {
						this.field1382[var4] = var1.readUnsignedByte() == 1;
					} else {
						this.field1382[var4] = false;
					}
				}

				this.updateOwner();
			}

			if (this.bannedMemberCount > 0) {
				if (this.useHashes && (this.bannedMemberHashes == null || this.bannedMemberHashes.length < this.bannedMemberCount)) {
					this.bannedMemberHashes = new long[this.bannedMemberCount];
				}

				if (this.useNames && (this.bannedMemberNames == null || this.bannedMemberNames.length < this.bannedMemberCount)) {
					this.bannedMemberNames = new String[this.bannedMemberCount];
				}

				for (var4 = 0; var4 < this.bannedMemberCount; ++var4) {
					if (this.useHashes) {
						this.bannedMemberHashes[var4] = var1.readLong();
					}

					if (this.useNames) {
						this.bannedMemberNames[var4] = var1.readStringCp1252NullTerminatedOrNull();
					}
				}
			}

			if (var2 >= 3) {
				var4 = var1.readUnsignedShort();
				if (var4 > 0) {
					this.parameters = new IterableNodeHashTable(var4 < 16 ? WorldMapIcon_1.method1401(var4) : 16);

					while (var4-- > 0) {
						int var5 = var1.readInt();
						int var6 = var5 & 1073741823;
						int var7 = var5 >>> 30;
						if (var7 == 0) {
							int var8 = var1.readInt();
							this.parameters.put(new IntegerNode(var8), (long)var6);
						} else if (var7 == 1) {
							long var10 = var1.readLong();
							this.parameters.put(new LongNode(var10), (long)var6);
						} else if (var7 == 2) {
							String var12 = var1.readStringCp1252NullTerminated();
							this.parameters.put(new ObjectNode(var12), (long)var6);
						}
					}
				}
			}

		} else {
			throw new RuntimeException("" + var2);
		}
	}
}