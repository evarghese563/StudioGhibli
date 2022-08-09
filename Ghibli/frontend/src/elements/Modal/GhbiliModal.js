import React from "react";
import TotModal from "./Tot/TotModal"
import CasModal from "./Cas/CasModal"
import GraModal from "./Gra/GraModal"
import KikModal from "./Kik/KikModal"
import SpiModal from "./Spi/SpiModal"
import HowModal from "./How/HowModal"
import tot from './images/tot.jpg'
import cas from './images/cas.jpg'
import gra from './images/gra.jpg'
import kik from './images/kik.jpg'
import spi from './images/spi.jpg'
import how from './images/how.jpg'
import styled from 'styled-components';

const Container = styled.div`

  display: flex;
  justify-content: center;
  align-items:center;
  height:100vh;
  
`;

const Button = styled.button`
    min-width: 100px;
    padding:0px px;
    border-radius:0px;
    border:none;
    background:#FFF;
    color:#fff;
    font-size:24px;
    cursor:pointer;
    margin-right:20px;

`;

const GhibliModal  = () =>{

    const[showTotModal, setTotShowModal] = React.useState(false)
    const[showHowModal, setHowShowModal] = React.useState(false)
    const[showCasModal, setCasShowModal] = React.useState(false)
    const[showGraModal, setGraShowModal] = React.useState(false)
    const[showKikModal, setKikShowModal] = React.useState(false)
    const[showSpiModal, setSpiShowModal] = React.useState(false)
    
    const openTotModal = () => {
    setTotShowModal(prev => !prev);
    };
    const openCasModal = () => {
    setCasShowModal(prev => !prev);
    };
    const openGraModal = () => {
    setGraShowModal(prev => !prev);
    };
    const openKikModal = () => {
    setKikShowModal(prev => !prev);
    };
    const openSpiModal = () => {
    setSpiShowModal(prev => !prev);
    };
    const openHowModal = () => {
    setHowShowModal(prev => !prev);
    };
    
    return(
    <Container>
        <Button onClick={openTotModal}> <img src={tot} alt="tot" height='300' /> </Button>
        <Button onClick={openCasModal}> <img src={cas} alt="cas" height='300' /> </Button>
        <Button onClick={openGraModal}> <img src={gra} alt="gra" height='300' /> </Button>
        <Button onClick={openKikModal}> <img src={kik} alt="gra" height='300' /> </Button>
        <Button onClick={openSpiModal}> <img src={spi} alt="gra" height='300' /> </Button>
        <Button onClick={openHowModal}> <img src={how} alt="gra" height='300' /> </Button>
        
        <TotModal showModal={showTotModal} setShowModal={setTotShowModal}/>
        <CasModal showModal={showCasModal} setShowModal={setCasShowModal}/>
        <GraModal showModal={showGraModal} setShowModal={setGraShowModal}/>
        <KikModal showModal={showKikModal} setShowModal={setKikShowModal}/>
        <SpiModal showModal={showSpiModal} setShowModal={setSpiShowModal}/>
        <HowModal showModal={showHowModal} setShowModal={setHowShowModal}/>
    </Container>
    )

}
    
    

export default GhibliModal