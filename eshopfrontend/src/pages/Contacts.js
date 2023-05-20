import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';

function Contacts() {
  return (
    <div>
      <section>
        <Container>
          <h2>Contact Us</h2>
          <Row>
            <Col md={6}>
              <h4>Customer Support</h4>
              <p>Email: support@example.com</p>
              <p>Phone: +1 123-456-7890</p>
              <p>Address: 123 Street, City, Country</p>
            </Col>
            <Col md={6}>
              <h4>Sales Inquiries</h4>
              <p>Email: sales@example.com</p>
              <p>Phone: +1 987-654-3210</p>
              <p>Address: 456 Street, City, Country</p>
            </Col>
          </Row>
        </Container>
      </section>
    </div>
  );
}

export default Contacts;
