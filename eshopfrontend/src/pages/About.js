import React from 'react';
import { Card, Container, Row, Col } from 'react-bootstrap';
import fieldOfFlowers from '../images_for_pages/field_of_flowers.jpg'
import flowerdeilivery from '../images_for_pages/flowerdelivery.jpg'
import flower_bucket from '../images_for_pages/flower_bucket.jpg'

function About() {
  return (
    <div>
      <section>
        <Container>
          <Row>
            <Col lg={6}>
              <h2>About Our Flower E-Shop</h2>
              <p>
                Welcome to our flower e-shop! We are dedicated to delivering the freshest and most beautiful flowers to our customers. 
                With a wide selection of floral arrangements, bouquets, and plants, we strive to provide the perfect gift for any occasion.
              </p>
            </Col>
            <Col lg={6}>
              <Card>
                <img variant="top" src={fieldOfFlowers} alt="Flower Shop" />
              </Card>
            </Col>
          </Row>
        </Container>
      </section>

      <section className="bg-light py-5">
        <Container>
          <Row>
            <Col lg={6}>
              <Card>
                <Card.Img variant="top" src={flower_bucket} alt="Flower Arrangements" />
              </Card>
            </Col>
            <Col lg={6}>
              <h2>Our Flower Arrangements</h2>
              <p>
                We take pride in our stunning flower arrangements created by our talented florists. Each arrangement is carefully designed 
                to showcase the natural beauty of the flowers. Whether you need a bouquet for a special occasion or to brighten someone's 
                day, we have the perfect floral arrangement for you.
              </p>
            </Col>
          </Row>
        </Container>
      </section>

      <section className="py-5">
        <Container>
          <Row>
            <Col lg={6}>
              <h2>Fast and Reliable Delivery</h2>
              <p>
                We understand the importance of timely delivery when it comes to sending flowers. Our dedicated delivery team ensures that 
                your floral gifts arrive fresh and on time. With our efficient delivery service, you can trust us to make your special 
                moments even more memorable.
              </p>
            </Col>
            <Col lg={6}>
              <Card>
                <Card.Img variant="top" src={flowerdeilivery} alt="Delivery" />
              </Card>
            </Col>
          </Row>
        </Container>
      </section>
    </div>
  );
}

export default About;