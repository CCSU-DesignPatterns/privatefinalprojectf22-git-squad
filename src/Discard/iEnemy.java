package Discard;

/**
 * Interface for enemy entities
 *
 * @author Ricardo Almeida
 */
public interface iEnemy extends iEntity {
    public void attack();
    public void takeDamage(int damageAmount);
}
