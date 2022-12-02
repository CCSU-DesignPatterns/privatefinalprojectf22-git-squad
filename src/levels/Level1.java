package levels;

import entity.SpriteNotFoundException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import entity.Direction;

public class Level1 extends Level {
    /**
     * Default constructor
     */
    public Level1() {
    	loadTileSet();
    	loadMap();
    }

    @Override
    protected void loadTileSet() {
        try {
            tileSet[0] = new MapTile("/tiles/Grass.png");

            tileSet[1] = new MapTile("/tiles/Path.png");
            tileSet[1].collision = true;
        }
        catch(SpriteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/levels/level01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Get the first line in the file and extract the start point and direction
            String firstLine[] = (br.readLine()).split(" ");
            startX = Integer.parseInt(firstLine[0]) * gp.TILE_SIZE;
            startY = Integer.parseInt(firstLine[1]) * gp.TILE_SIZE;
            startDir = Direction.valueOf(firstLine[2]);
            
            // Populate the map array
            for(int row = 0; row < gp.MAX_SCREEN_ROW; row++) {
                String line = br.readLine();
                String numbers[] = line.split(" ");

                for(int col = 0; col < gp.MAX_SCREEN_COL; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    levelMap[col][row] = num;
                    if(num == 1)
                    	pathLength++;
                }
            }

            br.close();
            
            pathLength *= gp.TILE_SIZE;
        }
        catch(Exception e) {
        	System.out.println("Could not find level data");
        }
    }
}
