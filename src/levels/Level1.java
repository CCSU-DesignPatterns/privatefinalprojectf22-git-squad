package levels;

import entity.SpriteNotFoundException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Level1 extends Level {
    // The level file for this level
    String levelData = "/levels/level01.txt";

    /**
     * Default constructor
     */
    public Level1() {
        // Needs further implementation
        super();
    }

    @Override
    protected void loadTileSet() {
        try {
            tileSet[0] = new MapTile("/tiles/Grass.png");
            //super.tileSet[0].setSprite("/tiles/Grass.png");

            tileSet[1] = new MapTile("/tiles/Path.png");
            //super.tileSet[1].setSprite("/tiles/Path.png");
        }
        catch(SpriteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream(levelData);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for(int row = 0; row < gp.MAX_SCREEN_ROW; row++) {
                String line = br.readLine();
                String numbers[] = line.split(" ");

                for(int col = 0; col < gp.MAX_SCREEN_COL; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    levelMap[col][row] = num;
                }
            }

            br.close();
        }
        catch(Exception e) {

        }
    }
}
