package campusCheckin;

import org.springframework.data.jpa.repository.JpaRepository;

import campusCheckin.Order;

interface OrderRepository extends JpaRepository<Order, Long> {
}
