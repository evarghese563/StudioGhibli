import React,{useRef, useState,useEffect} from 'react';
import {useSpring,animated} from 'react-spring';
import styled from 'styled-components';
import {MdClose} from 'react-icons/md';
import cas from './cas.jpg';


const Background = styled.div`
    width:100%;
    height:100%;
    background: rgba(0,0,0,0.8);
    position:fixed;
    display:flex;
    justify-content:center;
    align-items:center;
`

const ModalWrapper = styled.div`
    width:800px;
    height:600px;
    box-shadow: 0 5px 16px rgba(0,0,0,0.2);
    background:#fff;
    color:#000;
    display:grid;
    grid-template-columns: 1fr 1fr;
    position: relative;
    z-index:10;
    border-radius:10px;
    
`

const ModalImg = styled.img`
    width:100%;
    height:100%;
    border-radius:10px 0 0 10px;
    background: #000;

`

const ModalContent = styled.div`
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    line-height:1.8;
    color:#141414;

    p{
        margin-bottom:1rem;
    }

    button{
        padding:10px 24px;
        background: #141414;
        color:#fff;
        border:none;
    }
`;

const CloseModalButton= styled(MdClose)`
    cursor:pointer;
    position:absolute;
    top:20px;
    right:20px;
    width:32px;
    height:32px;
    z-index:10;
`;



export const CasModal = ({showModal, setShowModal}) =>{


    const ghibliurl = "/ghiblis/2"

    const [ghibliData, setghibliData] = useState({});

    useEffect(() => {
        getGhibliWithFetch();
      }, []);


    const getGhibliWithFetch = async () => {

        const response = await fetch(ghibliurl);
        const jsonData = await response.json();
        console.log(jsonData[0].title)
        setghibliData(jsonData[0]);
    };


    const modalRef = useRef()

    const animation = useSpring({
        config:{
            duration:250
        },
        opacity: showModal ? 1:0,
        transform: showModal ? `translateY(0%)` : `translateY(-100%)`
    })

    const closeModal = e =>{
        if(modalRef.current === e.target){
            setShowModal(false);
        }
    }


    return(
    <>
    {showModal ? (
        <Background ref={modalRef} onClick = {closeModal}>
            <animated.div style={animation}>
                <ModalWrapper showModal={showModal}>
                    <ModalImg src={cas} alt="castle" />

                    <ModalContent>
                    <h3 className="info-item">Movie: {ghibliData.title}</h3>
                    <h3 className="info-item">Director: {ghibliData.director}</h3>
                    <h3 className="info-item">Release Date: {ghibliData.release_date}</h3>
                    <h3 className="info-item">Running Time: {ghibliData.running_time} mins</h3>
                    </ModalContent>
                    
                    <CloseModalButton aria-label='Close Modal' onClick={() => setShowModal
                    (prev =>!prev)}></CloseModalButton>
                </ModalWrapper>
            </animated.div>
        </Background>
    ):null }
    </>
    )
};
export default CasModal;