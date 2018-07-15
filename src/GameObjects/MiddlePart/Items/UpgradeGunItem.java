package GameObjects.MiddlePart.Items;

import GameBasis.BattleField;
import GameObjects.GameObject;
import GameObjects.MiddlePart.MiddlePart;

public class UpgradeGunItem extends GameObject implements Item,MiddlePart {

    private BattleField battleField;
    private int gift = 1;

    public UpgradeGunItem(BattleField battleField, int locationX, int locationY){
        this.locationX = locationX;
        this.locationY = locationY;
        this.battleField = battleField;
        this.IMAGE_PATH += "UpgradeGunItem.png";
        setImage();
    }


    @Override
    public void act() {

    }

    @Override
    public void dispose() {
        isDeleted = true;
    }

    @Override
    public int getGift() {
        return gift;
    }
}
