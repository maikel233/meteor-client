import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rd")
@Implements("ObjectNode")
public class ObjectNode extends Node {
    @ObfuscatedName("af")
    public final Object obj;

   public ObjectNode(Object var1) {
      this.obj = var1;
   }
}
