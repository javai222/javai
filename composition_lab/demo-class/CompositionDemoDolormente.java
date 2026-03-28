public class CompositionDemoDolormente {
    public static void main(String[] args) {

        Libag libag = new Libag("batok", 8, true, "dark");
        Soap soap = new Soap("Safeguard", "Fresh", 10);
        Water water = new Water(2.5, 30, true);
        Skins skin = new Skins("Oily", "Brown", "Smooth");

        CleaningBody body = new CleaningBody(libag, soap, water, skin);

        body.startCleaning();
        body.showStatus();
        body.checkSkinAfterCleaning();
    }
}
