package enemy;

public class Wave {
	 Enemy enemies;
	private int difficulty;
	private int ENEMY_AMOUNT = 5; //multiplied by difficulty to get ammount of enemies.
	private String sprite;
	
	
	public Wave(int difficulty) {
		this.difficulty = difficulty;
		this.enemies = null;
		generateWave();
		
	}
	
	public void attack(int damage) {
		enemies.calcDamage(damage);
	}

	/**
	 * I will refactor on later sprints.
	 * */
	private void generateWave(){
			Enemy tempPrev;
			Enemy tempNext;
			switch (difficulty) {
			    case 2:
			    	this.enemies = new EnemyLevel_2();
			    	this.enemies.setPrevEnemy(null);
			    	tempPrev = this.enemies;
			    	for(int i = 0; i < ENEMY_AMOUNT * difficulty ;i++) {
			    		//for last iteration and last enemy in the chain
			    		if((i+1)==(ENEMY_AMOUNT*difficulty))
			    			tempPrev.setNextEnemy(null);
			    		else {
				    		tempNext = new EnemyLevel_2();
				    		tempPrev.setNextEnemy(tempNext);
				    		tempNext.setPrevEnemy(tempPrev);
				    		tempPrev = tempNext;
			    		}
			    		
			    	}
			    	break;
			    case 3:
			    	this.enemies = new EnemyLevel_3();
			    	this.enemies.setPrevEnemy(null);
			    	tempPrev = this.enemies;
			    	for(int i = 0; i < ENEMY_AMOUNT * difficulty ;i++) {
			    		//for last iteration and last enemy in the chain
			    		if((i+1)==(ENEMY_AMOUNT*difficulty))
			    			tempPrev.setNextEnemy(null);
			    		else {
				    		tempNext = new EnemyLevel_3();
				    		tempPrev.setNextEnemy(tempNext);
				    		tempNext.setPrevEnemy(tempPrev);
				    		tempPrev = tempNext;
			    		}
			    		
			    	}
			    	break;
			    default:
			    	this.enemies = new EnemyLevel_1();
			    	this.enemies.setPrevEnemy(null);
			    	tempPrev = this.enemies;
			    	for(int i = 0; i < ENEMY_AMOUNT * difficulty ;i++) {
			    		//for last iteration and last enemy in the chain
			    		if((i+1)==(ENEMY_AMOUNT*difficulty))
			    			tempPrev.setNextEnemy(null);
			    		else {
					    		tempNext = new EnemyLevel_1();
					    		tempPrev.setNextEnemy(tempNext);
					    		tempNext.setPrevEnemy(tempPrev);
					    		tempPrev = tempNext;
			    			}
			    		
			    		}
			    	break;
			}
			
		}
	
	
	
	
}
