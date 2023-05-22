import React from "react";
import { useAuth0 } from "@auth0/auth0-react";
import { Button, Image } from "react-bootstrap";


const LogoutButton = ({user}) => {
  const { logout } = useAuth0();


  return (
    <div>
      {console.log(user)}
    <Image src={user.picture} roundedCircle style={{width: '40px', height: '40px', marginRight: '10px'}}/>

    <Button variant="outline-secondary" onClick={() => logout({ logoutParams: { returnTo: window.location.origin } })}>
      Log Out
    </Button>
    </div>
  );
};

export default LogoutButton;