package entity;

/**
 * Generic entity factory for creating different types of entities
 *
 * @author Ricardo Almeida
 */
public interface iEntityFactory {
    iEntity createEntity(int type);
}
