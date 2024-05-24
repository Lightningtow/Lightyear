package lightningtow.lightyear;

import com.minenash.customhud.HudElements.supplier.BooleanSupplierElement;

import static com.minenash.customhud.data.Flags.wrap;
import static com.minenash.customhud.registry.CustomHudRegistry.registerElement;

import net.minecraft.client.MinecraftClient;


public class CustomhudIntegration {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void initCustomhud() {

            // don't put log messages here, messages already in Main

//            registerElement("falling_with_style", (f, c)
//                    ->  wrap(new BooleanSupplierElement(() -> LightyearMain.falling_with_style), f));
            registerElement("falling_with_style", (f, c)
                    ->  wrap(new BooleanSupplierElement(() -> {
                assert client.player != null;
                return client.player.isFallFlying();
            }), f));

        }
}
