# Node list query
SELECT u.id, u.name FROM user u;

# Edge list query
SELECT p1.user_id AS lhs, p2.user_id AS rhs
FROM permission p1, permission p2
WHERE p1.node_id = p2.node_id
AND p1.user_id < p2.user_id;

