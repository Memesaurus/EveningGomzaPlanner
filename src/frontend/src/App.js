import Button from 'react-bootstrap/Button';
import "./App.css"
import { Form } from 'react-bootstrap';
import { useState } from 'react';

function App() {
  const [plans, setPlans] = useState();
  const [mood, setMood] = useState();
  const username = 'admin'

  const submitValues = () => {
    fetch('http://localhost:8080/api/v1/plans', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({username: username, mood: mood, plans: plans})
    })
  }

  return (
    <>
    <div className='username'>
      {username}
    </div>
    <div className='content'>
      <div className='widgets'>
        <div className='formContainer'>
          <Form onChange={plans => setPlans(plans.target.id)}>
            <Form.Check type='radio' name='plans' id='LOL' label='Лига легенд' />
            <Form.Check type='radio' name='plans' id='NOT_LOL' label='Не лига легенд' />
            <Form.Check type='radio' name='plans' id='PIVO' label='Пью пиво' />
            <Form.Check type='radio' name='plans' id='LATE' label='Опаздываю' />
          </Form>
        </div>
        <div className='formContainer'>
          <Form onChange={mood => setMood(mood.target.id)}>
            <Form.Check type='radio' name='mood' id='ANGRY' label='На негативе' />
            <Form.Check type='radio' name='mood' id='SAD' label='Грустный' />
            <Form.Check type='radio' name='mood' id='READY_TO_PUMP' label='Готов к запампке' />
            <Form.Check type='radio' name='mood' id='SERIOUS' label='В пиджаке' />
            <Form.Check type='radio' name='mood' id='PIVO' label='Пью пиво' />
          </Form>
        </div>
      </div>
      <div className='btnContainer'>
        <Button variant='secondary' size='lg' onClick={submitValues}>Submit</Button>
      </div>
    </div>
    </>
  );
}

export default App;
