package entity.towers;

import entity.enemies.Enemy;

public class TowerTargetsLL {
	
	Node head;
	Node tail;
	
	/*
	 * Potentially better way to keep track of enemies:
	 * calculate length of path in TileManager based on levelMap[][]
	 * keep track of distance remaining in update() on enemy
	 * when enemy is within range of tower, add to tower's targets
	 * sort by enemy distance remaining on update() 
	 */
	
	public TowerTargetsLL(Enemy enemy){
		head = new Node(null, null, enemy);
		tail = head;
	}
	
	public void push(Enemy enemy) {
		Node toPush = new Node(head, null, enemy);
		head.prev = toPush;
		head = toPush;
	}
	
	public Enemy pop() {
		Enemy popped = head.enemy;
		Node newHead = head.next;
		newHead.prev = null;
		head.next = null;
		head = newHead;
		return popped;
	}
	
	public void queue(Enemy enemy) {
		Node toQueue = new Node(null, tail, enemy);
		tail.next = toQueue;
		tail = toQueue;
	}
	
	public Enemy dequeue() {
		Enemy dequeued = tail.enemy;
		Node newTail = tail.prev;
		newTail.next = null;
		tail.prev = null;
		tail = newTail;
		return dequeued;
	}
	
	public Enemy getHead() { return head.enemy; }
	
	public Enemy getTail() { return tail.enemy; }
	
	private class Node {
		
		Node next; // null on tail (nothing comes after)
		Node prev; // null on head (nothing comes before)
		Enemy enemy;
		
		public Node(Node next, Node prev, Enemy enemy) {
			this.next = next;
			this.prev = prev;
			this.enemy = enemy;
		}
	}
}
