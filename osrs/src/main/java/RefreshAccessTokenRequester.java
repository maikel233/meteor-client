import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.Future;

@Implements("com/jagex/oldscape/pub/RefreshAccessTokenRequester")
@ObfuscatedName("com/jagex/oldscape/pub/RefreshAccessTokenRequester")
public interface RefreshAccessTokenRequester {
	Future request(String var1, URL var2, Map var3, String var4);
}