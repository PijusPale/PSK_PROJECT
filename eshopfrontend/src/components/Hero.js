import React from 'react';
import { Carousel } from 'react-bootstrap';
import fieldOfFlowers from '../images_for_pages/field_of_flowers.jpg'
import flowerdeilivery from '../images_for_pages/flowerdelivery.jpg'
import flower_bucket from '../images_for_pages/flower_bucket.jpg'

const Hero = () => {
  return (
    <div>
      {/* <main> */}
        {/* <h1>Welcome to Flower Eshop!</h1> */}
        <Carousel>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src={fieldOfFlowers}
              alt="First slide"
            />
            <Carousel.Caption>
              <h3>Beautiful Flowers</h3>
              <p>Discover a wide variety of stunning flowers.</p>
            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src="image2.jpg"
              alt="Second slide"
            />
            <Carousel.Caption>
              <h3>Express Your Emotions</h3>
              <p>Let our flowers convey your heartfelt messages.</p>
            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src="image3.jpg"
              alt="Third slide"
            />
            <Carousel.Caption>
              <h3>Special Occasions</h3>
              <p>Make your special moments even more memorable with our floral arrangements.</p>
            </Carousel.Caption>
          </Carousel.Item>
        </Carousel>
      {/* </main> */}
    </div>
  );
};

export default Hero;
