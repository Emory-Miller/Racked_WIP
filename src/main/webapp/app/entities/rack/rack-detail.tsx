import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, openFile, byteSize } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './rack.reducer';

export const RackDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const rackEntity = useAppSelector(state => state.rack.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="rackDetailsHeading">
          <Translate contentKey="rackedApp.rack.detail.title">Rack</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{rackEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="rackedApp.rack.name">Name</Translate>
            </span>
          </dt>
          <dd>{rackEntity.name}</dd>
          <dt>
            <span id="longitude">
              <Translate contentKey="rackedApp.rack.longitude">Longitude</Translate>
            </span>
          </dt>
          <dd>{rackEntity.longitude}</dd>
          <dt>
            <span id="latitude">
              <Translate contentKey="rackedApp.rack.latitude">Latitude</Translate>
            </span>
          </dt>
          <dd>{rackEntity.latitude}</dd>
          <dt>
            <span id="image">
              <Translate contentKey="rackedApp.rack.image">Image</Translate>
            </span>
          </dt>
          <dd>
            {rackEntity.image ? (
              <div>
                {rackEntity.imageContentType ? (
                  <a onClick={openFile(rackEntity.imageContentType, rackEntity.image)}>
                    <img src={`data:${rackEntity.imageContentType};base64,${rackEntity.image}`} style={{ maxHeight: '30px' }} />
                  </a>
                ) : null}
                <span>
                  {rackEntity.imageContentType}, {byteSize(rackEntity.image)}
                </span>
              </div>
            ) : null}
          </dd>
        </dl>
        <Button tag={Link} to="/rack" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/rack/${rackEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default RackDetail;
