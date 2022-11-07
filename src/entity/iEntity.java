package entity;

import common.Coordinates;

/**
 * Interface for Entity objects
 *
 * @author Ricardo Almeida
 */
public interface iEntity {
    Coordinates getCurPos();
    void setPos(Coordinates curPos);
    void takeDamage(int damageAmount);
}
