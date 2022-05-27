package testing.buttons;

import arc.scene.style.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import mindustry.gen.*;
import testing.*;
import testing.ui.*;
import testing.util.*;

import static testing.ui.TUDialogs.*;

public class StatusMenu{
    public static Cell<ImageButton> addButton(Table t){
        ImageButton b = new ImageButton(statusDialog.getStatus().uiIcon, TUStyles.tuRedImageStyle);
        TUElements.boxTooltip(b, "@tu-tooltip.button-status");
        b.clicked(statusDialog::show);
        b.setDisabled(TestUtils::disableCampaign);
        b.resizeImage(40f);
        b.update(() -> {
            ((TextureRegionDrawable)(b.getStyle().imageUp)).setRegion(statusDialog.getStatus().uiIcon);
        });

        return t.add(b).growX();
    }

    public static void add(Table table){
        table.table(Tex.pane, t -> addButton(t).size(TUVars.iconSize, 40f));
    }
}
