import React from 'react';
import { Card, Container } from 'react-bootstrap';

function Faq() {
  return (
    <div>
      <section>
        <Container>
          <h2>Frequently Asked Questions</h2>
          <div className="my-4">
            <Card>
              <Card.Body>
                <Card.Title>Question 1: What is your return policy?</Card.Title>
                <Card.Text>
                  Answer 1: We have a 30-day return policy for our products. If you are not satisfied with your purchase, please contact our customer support team, and they will assist you with the return process.
                </Card.Text>
              </Card.Body>
            </Card>
          </div>
          <div className="my-4">
            <Card>
              <Card.Body>
                <Card.Title>Question 2: How long does shipping take?</Card.Title>
                <Card.Text>
                  Answer 2: The shipping time varies depending on your location. Generally, it takes 3-5 business days for domestic orders and 7-10 business days for international orders.
                </Card.Text>
              </Card.Body>
            </Card>
          </div>
          <div className="my-4">
            <Card>
              <Card.Body>
                <Card.Title>Question 3: Do you offer discounts for bulk orders?</Card.Title>
                <Card.Text>
                  Answer 3: Yes, we provide discounts for bulk orders. Please reach out to our sales team for more information and to discuss your specific requirements.
                </Card.Text>
              </Card.Body>
            </Card>
          </div>
        </Container>
      </section>
    </div>
  );
}

export default Faq;
