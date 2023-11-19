package org.ait.dogservices.mobtests;

import org.testng.annotations.Test;

public class FooterTests extends TestBaseMob{
    @Test
    public void isFacebookComponentPresentTest() {
        app.getFooterPageHelper().isFacebookComponentClickable();
    }

    @Test
    public void isInstagramComponentPresentTest() {
        app.getFooterPageHelper().isInstagramComponentClickable();
    }

    @Test
    public void isYoutubeComponentPresentTest() {
        app.getFooterPageHelper().isYoutubeComponentClickable();
    }
}
