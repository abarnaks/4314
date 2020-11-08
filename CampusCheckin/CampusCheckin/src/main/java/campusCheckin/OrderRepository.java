package campusCheckin;

import org.springframework.data.jpa.repository.JpaRepository;

import payroll.Order;

interface OrderRepository extends JpaRepository<Order, Long> {
}
