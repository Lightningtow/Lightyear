package lightningtow.lightyear;

// 3.3
import static com.minenash.customhud.mod_compat.CustomHudRegistry.registerElement;
import com.minenash.customhud.HudElements.HudElement;
import net.minecraft.client.MinecraftClient;
import java.util.function.Supplier;

 class CustomhudBoolSupplier implements HudElement {
    private final Supplier<Boolean> supplier;
    public CustomhudBoolSupplier(Supplier<Boolean> supplier) { this.supplier = supplier; }

    @Override
    public String getString() { return sanitize(supplier, false) ? "true" : "false"; }

    @Override
    public Number getNumber() { return sanitize(supplier, false) ? 1 : 0; }

    @Override
    public boolean getBoolean() { return sanitize(supplier, false); }
}
public class CustomhudIntegration {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void initCustomhud() {

            registerElement("falling_with_style", (_bool) -> new CustomhudBoolSupplier(() -> {
                assert client.player != null;
                return client.player.isFallFlying();
            }));
    }
}




// 4.0
//import com.minenash.customhud.HudElements.supplier.BooleanSupplierElement;
//import net.minecraft.client.MinecraftClient;
//
//import static com.minenash.customhud.data.Flags.wrap;
//import static com.minenash.customhud.registry.CustomHudRegistry.registerElement;
//
//public class CustomhudIntegration {
//    private static final MinecraftClient client = MinecraftClient.getInstance();
//
//    public static void initCustomhud() {
//
//            // don't put log messages here, messages already in Main
//
//            registerElement("falling_with_style", (f, c)
//                    ->  wrap(new BooleanSupplierElement(() -> {
//                assert client.player != null;
//                return client.player.isFallFlying();
//            }), f));
//
//        }
//}