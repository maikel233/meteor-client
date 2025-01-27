import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ri")
@Implements("Link")
public class Link {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lri;"
	)
	@Export("previous")
	public Link previous;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lri;"
	)
	@Export("next")
	public Link next;

	@ObfuscatedName("au")
	@Export("remove")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}
}